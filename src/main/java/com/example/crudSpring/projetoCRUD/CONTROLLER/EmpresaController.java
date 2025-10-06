package com.example.crudSpring.projetoCRUD.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.SERVICE.EmpresaService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/empresaCTR")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService ligacaoEmpresaService){
        this.empresaService = ligacaoEmpresaService;
    }

    @GetMapping("/listarTodasEmpresas")
    public String listarEmpresa(Model oModel) {
        oModel.addAttribute("empresas", empresaService.findAll());
        return "listarEmpresas";
    }
    
    
    @GetMapping("/viewCadEmpresa")
    public String mostrarFormCadrastro(Model model){
        model.addAttribute("empresa", new Empresa());
        return "cadastroEmpresa";
    }



    @PostMapping("/salvarEmpresa")
    public String salvarEmpresa(@ModelAttribute Empresa objempresa) {
    //chamando o metodo cadastrar e passando o objeto ("pacotinho") com os dados que precisam ser salvos
    empresaService.cadastarEmpresa(objempresa);

    return "redirect:/empresaCTR/listarTodasEmpresas";
}

@GetMapping("/editar/{id}")
public String formEditar(@PathVariable("id") Long id, Model oModel) {
    Empresa objEmpresa = empresaService.buscarPorId(id)
        .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
 
    oModel.addAttribute("empresaEditar", objEmpresa);
    return "editarEmpresa";
}

@PostMapping("/atualizarEmpresa") // serve para quando quiser cadastrar algo ou mudar no banco de dados
public String atualizarEmpresa(@PathVariable Long id, @ModelAttribute Empresa objEmpresaAtualizado) {

    return "redirect:/empresaCTR/listarTodasEmpresas";
}


}



