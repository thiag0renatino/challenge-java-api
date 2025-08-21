package com.fiap.challenge_api.controller.web;

import com.fiap.challenge_api.dto.MotoDTO;
import com.fiap.challenge_api.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/web/motos")
public class MotoWebController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public String list(Model model) {
        List<MotoDTO> motos = motoService.findAll();
        model.addAttribute("motos", motos);
        return "web/motos/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        MotoDTO form = new MotoDTO();
        form.setDataCadastro(LocalDate.now()); // default
        model.addAttribute("form", form);
        model.addAttribute("mode", "create");
        return "web/motos/form";
    }

    @PostMapping
    public String create(@ModelAttribute("form") MotoDTO form,
                         RedirectAttributes ra, Model model) {
        // regra de negócio/validação ficam na service
        MotoDTO created = motoService.insert(form);
        ra.addFlashAttribute("msg", "Moto criada com sucesso! ID #" + created.getIdMoto());
        return "redirect:/web/motos";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        MotoDTO form = motoService.findById(id);
        model.addAttribute("form", form);
        model.addAttribute("mode", "edit");
        return "web/motos/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @ModelAttribute("form") MotoDTO form,
                         RedirectAttributes ra) {
        motoService.update(id, form);
        ra.addFlashAttribute("msg", "Moto atualizada com sucesso!");
        return "redirect:/web/motos";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {
        motoService.delete(id);
        ra.addFlashAttribute("msg", "Moto removida.");
        return "redirect:/web/motos";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("moto", motoService.findById(id));
        return "web/motos/detail";
    }
}