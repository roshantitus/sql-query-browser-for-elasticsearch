/**
 * 
 */
package org.webplans.sqltools.sql2nosql.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webplans.sqltools.sql2nosql.service.QueryService;

/**
 * @author Roshan Titus
 *
 */
@Controller
@RequestMapping(value="/query.html")
public class QueryController {

	private QueryService queryService;
	
	@Autowired
    public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}
	
    @RequestMapping(method=RequestMethod.GET)
    public String showQueryForm(Model model) 
    {
        return "query";
    }
}
