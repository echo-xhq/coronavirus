package com.xhq.coronavirus.controller;/*
Created by shkstart on 2020/2/23.
*/

import com.github.pagehelper.PageInfo;
import com.xhq.coronavirus.entity.Cure;
import com.xhq.coronavirus.entity.User;
import com.xhq.coronavirus.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CureController {
    @Autowired
    CureService service;
    //所有治愈者
    @RequestMapping(value = "cure/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25")int size){
        List<Cure> cures = service.findAll(page,size);
        PageInfo<User> pageInfo=new PageInfo(cures);
        model.addAttribute("pageInfo",pageInfo);
        return "list";


    }
    //根据id查找治愈者
    @RequestMapping(value = "cure/info/{id}",method = RequestMethod.GET)
    public String info(@PathVariable("id")int id,Model model){
        Cure cure = service.get(id);
        model.addAttribute("cure",cure);
        return "cureInfo";
    }
    //更新或插入治愈者的现状
    @RequestMapping(value = "cure/update",method = RequestMethod.GET)
    public String update(int baseId,String current){

        service.update(baseId,current);
        System.out.println(baseId+current);
        return "redirect:/cure/info/"+baseId;
    }


}
