package com.example.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@CrossOrigin
public class ReactRouteController {

    @RequestMapping(value = {"/*"})
    public String returnAllIndexPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String servletPath = request.getServletPath();
        if(servletPath.endsWith("index.html")){

            File indexFile = new File(request.getSession().getServletContext().getRealPath("/prototype/index.html"));
            String indexContent = FileUtils.readFileToString(indexFile);

            PrintWriter writer = response.getWriter();
            writer.print(indexContent);
            writer.flush();
            response.flushBuffer();

            return null;
        }else{
            return "redirect:/index.html";
        }
    }

}
