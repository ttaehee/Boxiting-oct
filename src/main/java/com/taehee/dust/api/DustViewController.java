package com.taehee.dust.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DustViewController {

    private final DustFacadeService dustFacadeService;

    @GetMapping
    public String index(Model model) {
        List<String> locations = dustFacadeService.getAllLocation();
        model.addAttribute("location", locations);
        return "index";
    }
}
