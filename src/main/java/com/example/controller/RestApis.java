package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentInfo;
import com.example.service.ProjectFrogDef;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestApis {
	@Autowired
	ProjectFrogDef frogSer;
	
	 @GetMapping("/token")
	    public Map<String,String> token(HttpSession session) {
	      return Collections.singletonMap("token", session.getId());
	    }
	
	@RequestMapping(value = "/api/addStudentDetails", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
   public ResponseEntity<StudentInfo> addStudentDetails(@RequestBody StudentInfo parameters) throws Exception {
      
       if (StringUtils.isEmpty(parameters)) {
           return new ResponseEntity("please add proper data!", HttpStatus.OK);
       }
       System.out.println(parameters);
       StudentInfo id=frogSer.addStudentInfo(parameters);
       
	   System.out.println(id);
       if(id==null)
       {
    	   return new ResponseEntity<StudentInfo>(HttpStatus.NOT_FOUND);
       }
       else
       {
     	   return new ResponseEntity<StudentInfo>(id, HttpStatus.OK);
       }
       
   }
	@RequestMapping(value = "/api/deleteById/{id}", method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
   public ResponseEntity<List<StudentInfo>> deleteById(@PathVariable("id") String name) throws Exception {
      
       if (StringUtils.isEmpty(name)) {
           return new ResponseEntity("please add proper data!", HttpStatus.OK);
       }
       System.out.println(name);
       List<StudentInfo> students=frogSer.deleteById(name);
       
	   
       if(students==null)
       {
    	   return new ResponseEntity<List<StudentInfo>>(HttpStatus.NOT_FOUND);
       }
       else
       {
     	   return new ResponseEntity<List<StudentInfo>>(students, HttpStatus.OK);
       }
       
   }
	@RequestMapping(value = "/api/getStudentInfoByName/{name}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<StudentInfo>> getStudentByFirst(@PathVariable("name") String name) throws Exception {
       List<StudentInfo> students=frogSer.getStudentInfoByName(name);
	   System.out.println(students);
	   if(students==null)
       {
    	 
    	   return new ResponseEntity<List<StudentInfo>>(HttpStatus.NOT_FOUND);      
       }
       else
       {
    	   return new ResponseEntity<List<StudentInfo>>(students, HttpStatus.OK);         
       }
     }
	@RequestMapping(value = "/api/getStudentInfoByLastName/{name}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<StudentInfo>> getStudentByLast(@PathVariable("name") String name) throws Exception {
       List<StudentInfo> students=frogSer.getStudentInfoByLastName(name);
	   System.out.println(students);
	   if(students==null)
       {
    	 
    	   return new ResponseEntity<List<StudentInfo>>(HttpStatus.NOT_FOUND);      
       }
       else
       {
    	   return new ResponseEntity<List<StudentInfo>>(students, HttpStatus.OK);         
       }
     }
	
	@RequestMapping(value = "/api/getStudentInfoByclassDetails/{class}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<StudentInfo>> getStudentByClass(@PathVariable("class") String name) throws Exception {
       List<StudentInfo> students=frogSer.getStudentInfoByClass(name);
	   System.out.println(students);
	   if(students==null)
       {
    	 
    	   return new ResponseEntity<List<StudentInfo>>(HttpStatus.NOT_FOUND);      
       }
       else
       {
    	   return new ResponseEntity<List<StudentInfo>>(students, HttpStatus.OK);         
       }
     }
	
	@RequestMapping(value = "/api/getStudentInfoById/{id}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<StudentInfo>> getStudentInfoById(@PathVariable("id") long id) throws Exception {
       List<StudentInfo> students=frogSer.getStudentInfoById(id);
	   System.out.println(students);
	   if(students==null)
       {
    	 
    	   return new ResponseEntity<List<StudentInfo>>(HttpStatus.NOT_FOUND);      
       }
       else
       {
    	   return new ResponseEntity<List<StudentInfo>>(students, HttpStatus.OK);         
       }
       
   }
	@RequestMapping(value = "/api/updateByData", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<StudentInfo>> uddateByDetails(@RequestBody StudentInfo parameters) throws Exception {
       List<StudentInfo> students=frogSer.updateByDetails(parameters);
	   System.out.println(students);
	   if(students==null)
       {
    	 
    	   return new ResponseEntity<List<StudentInfo>>(HttpStatus.NOT_FOUND);      
       }
       else
       {
    	   return new ResponseEntity<List<StudentInfo>>(students, HttpStatus.OK);         
       }
       
   }
	@RequestMapping(value="/api/logout", method = RequestMethod.GET)
    public ResponseEntity<String> logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        
        return new ResponseEntity<String>(HttpStatus.OK);//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
