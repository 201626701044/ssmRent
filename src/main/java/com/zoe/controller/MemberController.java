package com.zoe.controller;

import com.alibaba.fastjson.JSONObject;
import com.zoe.pojo.Member;
import com.zoe.service.MemberService;
import com.zoe.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class MemberController {
    @ResponseBody
    @RequestMapping("/submitMember")
    public String submitMember(@RequestBody Member member) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Member对象:"+member);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneMember")
    public String getOneMember() {
        Member c = new Member();
        c.setMember_ID(100);
        c.setMember_name("第100个分类");
        JSONObject json= new JSONObject();
        json.put("member", JSONObject.toJSON(c));
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyMember")
    public String getManyMember() {
        List<Member> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Member c = new Member();
            c.setMember_ID(i);
            c.setMember_name("分类名称:"+i);
            cs.add(c);
        }

        return JSONObject.toJSON(cs).toString();
    }

//	@Autowired
//	MemberService memberService;
//
//	@RequestMapping("listMember")
//	public ModelAndView listMember(Page page){
//		ModelAndView mav = new ModelAndView();
//		//PageHelper.offsetPage(page.getStart(),5);
//		List<Member> cs= memberService.list(page);
//		//int total = (int) new PageInfo<>(cs).getTotal();
//		int total = memberService.total();
//
//		page.caculateLast(total);
//
//		// 放入转发参数
//		mav.addObject("cs", cs);
//		// 放入jsp路径
//		mav.setViewName("listMember");
//		return mav;
//	}
//
//    @RequestMapping("addMember")
//    public ModelAndView addMember(Member member){
//        memberService.add(member);
//        ModelAndView mav = new ModelAndView("redirect:/listMember");
//        return mav;
//    }
//    @RequestMapping("deleteMember")
//    public ModelAndView deleteMember(Member member){
//        memberService.delete(member);
//        ModelAndView mav = new ModelAndView("redirect:/listMember");
//        return mav;
//    }
//    @RequestMapping("editMember")
//    public ModelAndView editMember(Member member){
//        Member c= memberService.get(member.getMember_ID());
//        ModelAndView mav = new ModelAndView("editMember");
//        mav.addObject("c", c);
//        return mav;
//    }
//    @RequestMapping("updateMember")
//    public ModelAndView updateMember(Member member){
//        memberService.update(member);
//        ModelAndView mav = new ModelAndView("redirect:/listMember");
//        return mav;
//    }
//

}
