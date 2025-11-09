
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HamsterController {

    @Autowired
    private HamsterService hamsterService;

    /**
    * Endpoint to get all hamsters
    * 
    * @return List of all hamsters
    */
    @GetMapping({"/hamsters", "/hamsters/"})
    public Object getAllHamsters(Model model) {
        model.addAttribute("hamstersList", hamsterService.getAllHamsters());
        model.addAttribute("title", "All Hamsters");
        return "hamsters-list";
    }

    /**
    *Endpoint to get a hamster by ID
    *
    * @param id The ID of the hamster to retrieve
    * @return The hamster with the specified ID
    */
    @GetMapping("/hamsters/{id}")
    public String getHamsterByID(@PathVariable long id, Model model) {
        model.addAttribute("hamster", hamsterService.getHamsterById(id));
        model.addAttribute("title", "Hamster #: " + id);
        return "hamsters-details";
    }

    /**
    * Endpoint to get hamsters by name
    *
    * @param name The name of the hamster to search for
    * @return List of hamsters with the specified name
    */
    @GetMapping("/hamsters/name")
    public Object getHamstersByName(@RequestParam String key, Model model) {
        if (key != null) {
            model.addAttribute("hamstersList", hamsterService.getHamstersByName(key));
            model.addAttribute("title", "Hamsters By Name: " + key);
            return "hamsters-list";
        } else {
            return "redirect:/hamsters/";
        }
    }

    /**
     * 
     * @param breed
     * @param breed THe breed to search for
     * @return List of hamsters with the specified breed
     */
    @GetMapping("/hamsters/breed/{breed}")
    public Object getHamstersByBreed(@PathVariable String breed, Model model) {
        model.addAttribute("hamstersList", hamsterService.getHamstersByBreed(breed));
        model.addAttribute("title", "Hamsters By Breed: " + breed);
        return "hamsters-list";
    }

    /**
     * Endpoint to get hamsters with age above one
     *
     * @param age The age threshold for hamsters
     * @return List of hamsters of the specified age
     */
    @GetMapping("/hamsters/older")
    public Object getHamstersByAge(@RequestParam(name = "age", defaultValue = "1.0") double age, Model model) {
        model.addAttribute("hamstersList", hamsterService.getHamstersByAge(age));
        model.addAttribute("title", "Hamsters By Age: " + age);
        return "hamsters-list";
    }

    /**
     * Endpoint to show the create form for a new student
     * 
     * @param model the model to add the attributes to
     * @return The view name for the create form
     */
    @GetMapping("/hamsters/createForm")
    public Object showCreateForm(Model model) {
        Hamster hamster = new Hamster();
        model.addAttribute("hamster", hamster);
        model.addAttribute("title", "Create New Hamster");
        return "hamsters-create";
    }
    /**
     * Endpoint to add a new hamster
     *
     * @param hamster The hamster to add
     * @return List of all hamsters
     */
    @PostMapping("/hamsters")
    public Object addStudent(Hamster hamster, @RequestParam MultipartFile picture) {
        Hamster newHamster = hamsterService.addHamster(hamster, picture);
        return "redirect:/hamsters/" + newHamster.getHamsterId();
    }

    /**
     * @param id    The id of the hamster to update
     * @param model The model to add attributes to
     * @return      The view name for the update form
     */
    @GetMapping("/hamsters/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Hamster hamster = hamsterService.getHamsterById(id);
        model.addAttribute("hamster", hamster);
        model.addAttribute("title", "Update Hamster: " + id);
        return "hamsters-update";
    }

    /**
     * Endpoint to update a hamster
     *
     * @param id      The ID of the hamster to update
     * @param hamster The updated hamster information
     * @return The updated hamster
     */
    // @PutMapping("/hamsters/{id}")
    @PostMapping("/hamsters/update/{id}")
    public Object updateHamster(@PathVariable Long id, Hamster hamster, @RequestParam MultipartFile picture) {
        hamsterService.updateHamster(id, hamster, picture);
        return "redirect:/hamsters/" + id;
    }

    /**
     * Endpoint to delete a hamster
     *
     * @param id The ID of the hamster to delete
     * @return List of all hamsters
     */
    // @DeleteMapping("/hamsters/{id}")
    @GetMapping("/hamsters/delete/{id}")
    public Object deleteHamster(@PathVariable Long id) {
        hamsterService.deleteHamster(id);
        return "redirect:/hamsters";
    }

}