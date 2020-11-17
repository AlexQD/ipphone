package ru.radcenter.ipphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.model.Historys;
import ru.radcenter.ipphone.services.AccountService;
import ru.radcenter.ipphone.services.HistoryService;
import ru.radcenter.ipphone.services.RequestService;
import java.text.ParseException;


@Controller
public class HistoryController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String Index(Model model)  {
        return "index";
    }
    
    @RequestMapping(value = {"gethistory"}, method = RequestMethod.GET)
    public String GetHistory(Model model) throws ParseException {
        //Сервис requestService загружает историю звонков и парсит ее
        Historys historys = requestService.mappingHistory();
        model.addAttribute("historys", historys);
        model.addAttribute("account_service", accountService);
        return "history_all";
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.GET)
    public String SaveHistory(Model model) throws ParseException {
        //Сервис requestService загружает историю звонков и парсит ее
        Historys historys = requestService.mappingHistory();

        for (int i = 0; i < historys.getHistory_array().size(); ++i) {
            historyService.save(historys.getHistory_array().get(i));
        }

        model.addAttribute("historys", historys);
        return "history_all";
    }

}
