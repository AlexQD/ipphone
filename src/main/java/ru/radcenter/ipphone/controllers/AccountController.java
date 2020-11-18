package ru.radcenter.ipphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.radcenter.ipphone.dto.AccountDto;
import ru.radcenter.ipphone.services.AccountService;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/account")
final public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<String> addAccount(@RequestBody AccountDto accountDto) {
        if (isEmpty(accountDto)) {
            return ResponseEntity.badRequest().build();
        }

        accountService.save(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
