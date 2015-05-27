/**
 * 
 */
package org.webplans.sqltools.sql2nosql.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webplans.sqltools.sql2nosql.service.QueryService;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;
import org.webplans.sqltools.sql2nosql.web.vo.Connection;



/**
 * @author Roshan Titus
 *
 */
@Controller
@RequestMapping(value="/connection.html")
public class ConnectionController {

	private QueryService queryService;
	
	@Autowired
    public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	@RequestMapping(method=RequestMethod.GET)
    public String showConnectionForm(Model model) 
    {
    	Connection connection = new Connection();
    	model.addAttribute(connection);
    	model.addAttribute("datasourceList", queryService.getAllDatasources());
    	return "connection";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String handleConnectionRequest(HttpServletRequest request, Connection connection, BindingResult result) throws Exception 
    {
    	DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(connection.getDataSourceCode(), connection.getHostname(), Integer.valueOf(connection.getPort()));
    	request.getSession().setAttribute("dataSourceConnectionParameters", dataSourceConnectionParameters);
    	request.getSession().setAttribute("indexList", queryService.getAllIndices(dataSourceConnectionParameters));
    	return "query";
    }
}
