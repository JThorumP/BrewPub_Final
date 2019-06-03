// Lavet af -Alle
package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.AddressService;
import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.ItemService;
import com.example.demo.Service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
Denne klasse håndterer forbindelserne mellem HTML-sidernes input
og sorterer det til de rette sektioner i programmet
 */
@Controller
public class HomeController {
    //Her bliver der automatisk skabt en forbindelse til ItemService
    @Autowired
    ItemService itemService;
    //Her bliver der automatisk skabt en forbindelse til AddressService
    @Autowired
    AddressService addressService;
    //Her bliver der automatisk skabt en forbindelse til EmployeeService
    @Autowired
    EmployeeService employeeService;
    //Her bliver der automatisk skabt en forbindelse til RosterService
    @Autowired
    RosterService rosterService;

    //Denne metode viser startsiden, som spørger hvilken bruger man er
    @GetMapping("/")
    public String userChoice(){
        return "home/userChoice";
    }

    //Denne metoder viser login for lederen, hvilket kræver lederen ID og kodeord
    @GetMapping("/leaderLogin")
    public String leaderChoice(){
        return "home/leaderLogin";
    }
    //Denne metode tester for korrekt login, og ud fra resultatet bliver man dirigeret til tilsvarende side
    @PostMapping("/leaderLogin")
    public String leaderLogin(@ModelAttribute LeaderLogin leaderTest){
        if (employeeService.fetchLeader(leaderTest)) {
            return "home/index";
        }
        return "home/leaderLogin";
    }


    //Denne metode viser hvilke valgmuligheder man har som leder: Ansatte, Vagtplan, Lagerbeholdning
    @GetMapping("/index")
    public String index(){
        return "home/index";
    }

    //Denne metode viser lagerbeholdningen, med mulighed for at tilføje, opdatere eller slette en vare
    @GetMapping("/item")
    public String item(Model model){
        List<Item> itemList = itemService.fetchAll();
        model.addAttribute("items", itemList);
        return "item/item";
    }
    //Denne metode tilføjer en vare til lagerbeholdningen og opdaterer listen
    @PostMapping("/item")
    public String createItem(@ModelAttribute Item item){
        itemService.addObject(item);
        return "redirect:/item";
    }

    //Denne metode viser en side med mulighed for at rette informationerne om den valgte vare
    @GetMapping("/updateItem/{id}")
    public String updateItem(Model model, @PathVariable("id") int id){
        model.addAttribute("item", itemService.fetchById(id));
        return "item/updateItem";
    }
    //Denne metode gemmer de ændrede informationer om den vare der blev valgt fra forrige side
    @PostMapping("/updateItem")
    public String updateItem(@ModelAttribute Item item){
        itemService.update(item);
        return "redirect:/item";
    }

    //Denne metode viser en side over eksisterende kategorier og giver mulighed for at vælge en kategori
    @GetMapping("/categoryChoice")
    public String categoryChoice(Model model){
        List<Item> categoryList = itemService.category();
        model.addAttribute("categories", categoryList);
        return "item/categoryChoice";
    }

    //Denne metode viser en side med en liste af varer indenfor den kategori der er valgt fra forrige side
    @GetMapping("/showCategory/{category}")
    public String showCategory(Model model, @PathVariable("category") String choice){
        List<Item> categoryList = itemService.catChoice(choice);
        model.addAttribute("choice", choice);
        model.addAttribute("category", categoryList);
        return "item/showCategory";
    }

    //Denne metode sletter en vare med det valgte id
    @GetMapping("/deleteItem/{id}")
    public String delete(@PathVariable("id")int id){
        boolean deleted = itemService.deleteById(id);
        if (deleted){
            return "redirect:/item";
        } else{
            return "redirect:/item";
        }
    }


    //Denne metode viser de ansatte, med mulighed for at tilføje, se fuld information, opdatere, slette en ansat
    //samt se en liste med fuld information for alle ansatte
    @GetMapping("/employee")
    public String employee(Model model){
        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);
        return "employee/employee";
    }

    //Denne metode viser siden for tilføjelse af en ansat
    @GetMapping("/addEmployee")
    public String addEmployee(){
        return "employee/addEmployee";

    }
    //Denne metode sender de indtastede informationer om den tilføjede ansatte videre til de rette steder i programmet
    //for oprettelse af en
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee_Address emp_add){
        addressService.addObject(emp_add);
        employeeService.addObject(emp_add);
        rosterService.addObject();
        return "redirect:/employee";
    }

    //Denne metode viser en side med information en ansat ud fra det valgte id
    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(Model model, @PathVariable("id") int id){
        model.addAttribute("employee", employeeService.fetchById(id));
        model.addAttribute("address", addressService.fetchById(id));
        return "employee/updateEmployee";
    }
    //Denne metode gemmer de ændrede informationer om den ansatte der blev valgt fra forrige side
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee_Address emp_add){
        addressService.update(emp_add);
        employeeService.update(emp_add);
        return "redirect:/employee";
    }

    //Denne metode sletter en ansat med det valgte id
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")int id){
        boolean rostDeleted = rosterService.deleteById(id);
        boolean empDeleted = employeeService.deleteById(id);
        boolean addDeleted = addressService.deleteById(id);
        if (empDeleted && addDeleted && rostDeleted){
            return "redirect:/employee";
        } else{
            return "redirect:/employee";
        }
    }

    //Denne metode viser fuld information om 1 ansat ud fra det valgte id
    @GetMapping("/viewInfo/{id}")
    public String viewOne(Model model, @PathVariable("id") int id){
        model.addAttribute("employee", employeeService.fetchById(id));
        model.addAttribute("address1", addressService.fetchById(id));
        return "employee/viewInfo";
    }

    //Denne metode viser fuld information om alle ansatte i databasen
    @GetMapping("/printEmployeeList")
    public String printEmployeeList(Model model){
        List<Employee_Address> fullList = employeeService.fullList();
        model.addAttribute("fullList", fullList);
        return "employee/printEmployeeList";
    }



    //Denne metode viser vagtplanen, med mulighed for at opdatere vagtplanen
    @GetMapping("/roster")
    public String roster(Model model){
        List<Roster_Employee> rosterList = rosterService.fetchFullList();
        model.addAttribute("rosters", rosterList);
        return "roster/roster";
    }

    //Denne metode opdaterer vagtplanen med de indtastede oplysninger ud fra det valgte id
    @GetMapping("/updateRoster/{id}")
    public String roster(@PathVariable("id") int id, @ModelAttribute Roster roster){
        rosterService.update(id, roster);
        return "redirect:/roster";
    }

    //Denne metode viser den printervenlig udgave af vagtplanen for lederen
    @GetMapping("/printRoster")
    public String printRoster(Model model){
        List<Roster_Employee> rosterList = rosterService.fetchFullList();
        model.addAttribute("rosters", rosterList);
        return "roster/printRoster";
    }

    //Denne metode viser den printervenlig udgave af vagtplanen for de ansatte
    @GetMapping("/employeeRosterList")
    public String employeeRosterList(Model model){
        List<Roster_Employee> rosterList = rosterService.fetchFullList();
        model.addAttribute("rosters", rosterList);
        return "roster/employeeRosterList";
    }

}
