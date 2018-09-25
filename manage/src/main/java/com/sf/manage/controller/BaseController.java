package com.sf.manage.controller;

import com.sf.manage.enums.MemberStatus;
import com.sf.manage.enums.MemberType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class BaseController {
    private static final DateTimeFormatter LOCAL_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter LOCAL_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(LocalDate.class, (PropertyEditorSupport) (text)-> {
//            this.setValue(LocalDate.parse(text, LOCAL_DATE));
//        });

        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(LocalDate.parse(text, LOCAL_DATE));
            }
        });

        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(LocalDate.parse(text, LOCAL_DATE_TIME));
            }
        });

        binder.registerCustomEditor(MemberStatus.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if(StringUtils.hasText(text)){
                    this.setValue(MemberStatus.getEnum(text));
                }
            }
        });

        binder.registerCustomEditor(MemberType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if(!text.isEmpty()){
                    this.setValue(MemberType.getEnum(text));
                }

            }
        });
    }
}
