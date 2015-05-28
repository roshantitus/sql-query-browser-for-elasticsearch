package org.webplans.sqltools.sql2nosql.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webplans.sqltools.sql2nosql.service.QueryService;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;
import org.webplans.sqltools.sql2nosql.web.command.QueryCommand;

/**
 * @author Roshan Titus
 *
 */
@Controller
public class QueryController {

	final Logger logger = LoggerFactory.getLogger(QueryController.class);
	
	private QueryService queryService;
	
	@Autowired
    public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	@RequestMapping(value="/connection.html", method=RequestMethod.GET)
    public String showConnectionForm(Model model) 
    {
    	QueryCommand queryCommand = new QueryCommand();
    	queryCommand.setDatasources(queryService.getAllDatasources());
    	model.addAttribute(queryCommand);
    	return "connection";
    }
    
    @RequestMapping(value="/connection.html", method=RequestMethod.POST)
    public String handleConnectionRequest(HttpServletRequest request, QueryCommand queryCommand, BindingResult result) throws Exception 
    {
    	DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(queryCommand.getDataSourceCode(), queryCommand.getHostname(), Integer.valueOf(queryCommand.getPort()));
    	queryCommand.setIndexes(queryService.getAllIndices(dataSourceConnectionParameters));
    	return "query";
    }
    
    @RequestMapping(value="/query.html", method=RequestMethod.POST)
    public String handleQueryRequest(HttpServletRequest request, QueryCommand queryCommand, BindingResult result) throws Exception 
    {
    	logger.info(queryCommand.toString());
    	return "query";
    }
}
