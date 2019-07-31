package net.Spring.Controller;
//import net.Spring.Retrieve.Beaches.Bentota.Aggregator;
//import net.Spring.Retrieve.Beaches.Bentota.DBClass;
import net.Spring.asr.GetData;
import net.Spring.asr.GetData2;
import net.Spring.asr.GetData3;
import net.Spring.asr.GetData4;
import net.Spring.dc.DBClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

   // private final InsertDataService insertDataService;

 // InsertDataService insertDataService = new InsertDataService();
  //  Aggregator agg = new Aggregator();
   /* @Autowired
    public HelloController(final InsertDataService insertDataService) {
        this.insertDataService = insertDataService;
    }*/


    // @GetMapping("/hello")
    @RequestMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("name", "Admin");

        return "welcome";
    }

    @RequestMapping("/insert")
    public String insert(Model model) throws Exception {
        //insertDataService.insertD();
        model.addAttribute("name1", "Admin");
        return "insert";
    }
    @RequestMapping("/retrieve")
    public String retrive(Model model) {
        //insertDataService.insertD();
        model.addAttribute("name2", "Admin");
        return "retrieve";
    }

    @RequestMapping("/retrieveAll")
    public String retrieveAll(Model model) {
        //insertDataService.insertD();
        model.addAttribute("name3", "Admin");
        return "retrieveAll";
    }

   /* @RequestMapping("/retrieveBentota")
    public String retrieveBentota(HttpSession session, Model model) throws IOException {
        //insertDataService.insertD();
        BBAllDataToFile obj = new BBAllDataToFile();
        boolean result = obj.gettingFromMongo();
        if (result) {
            model.addAttribute("successMsg", " Bentota data File is successfully created");
            return "successPage";
        } else {
            model.addAttribute("errorMsg", "Your form submission contains errors.");
            return "errorPage";
        }
    }*/


    /*@RequestMapping("/runbentota")
    public String runbentota(HttpSession session, Model model) throws Exception {
        //insertDataService.insertD();
        DBClass obj = new DBClass();
        boolean result = obj.gettingFromMongo();
        if (result) {
            model.addAttribute("successMsg", " Bentota data File is successfully created");
            return "successPage";
        } else {
            model.addAttribute("errorMsg", "Your form submission contains errors.");
            return "errorPage";
        }
    }
*/



    @RequestMapping("/execute")
    public String execute(Model model) throws Exception {
        //insertDataService.insertD();
        DBClass obj = new DBClass();
        boolean result = obj.gettingFromMongo();
        if (result) {
            model.addAttribute("successMsg", " Bentota data File is successfully created");
            return "successPage";
        } else {
            model.addAttribute("errorMsg", "Your form submission contains errors.");
            return "errorPage";
        }
    }


    /*@RequestMapping("/swimming")
    public String swimming(Model model) {
        //insertDataService.insertD();
       // agg.getBeachActivity();
        model.addAttribute("name4", "Admin");
        return "execute";
    }
*/

    @RequestMapping("/beachactivity")
     public String showDataFeed(Model m) {
        GetData getData = new GetData();
            List datafeeds = getData.getData();
            String sugession = getData.dummy;

            m.addAttribute("datafeedsForm", datafeeds);
            m.addAttribute("sugession", sugession);
            return "datafeed";


    /*Do your processing here*/

    }

    @RequestMapping("/beachscenic")
    public String showDataFeed2(Model m) {
        GetData2 getData2 = new GetData2();
        List datafeeds2 = getData2.getData();
        String sugession2 = getData2.dummy;

        m.addAttribute("datafeedsForm2", datafeeds2);
        m.addAttribute("sugession2", sugession2);
        return "datafeed2";


    /*Do your processing here*/

    }

    @RequestMapping("/natureactivity")
    public String showDataFeed3(Model m) {
        GetData3 getData3 = new GetData3();
        List datafeeds3 = getData3.getData();
        String sugession3 = getData3.dummy;

        m.addAttribute("datafeedsForm3", datafeeds3);
        m.addAttribute("sugession3", sugession3);
        return "datafeed3";


    /*Do your processing here*/

    }

    @RequestMapping("/naturescenic")
    public String showDataFeed4(Model m) {
        GetData4 getData4 = new GetData4();
        List datafeeds4 = getData4.getData();
        String sugession4 = getData4.dummy;

        m.addAttribute("datafeedsForm4", datafeeds4);
        m.addAttribute("sugession4", sugession4);
        return "datafeed4";


    /*Do your processing here*/

    }



    //return "welcome";
}

