package app.qienuren.controller;

import app.qienuren.model.Mail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mail")
public class MailController {

    private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN') or hasAnyRole('GEBRUIKER') or hasAnyRole('BEDRIJF')")
    public void sendMail(@RequestBody Mail mail) {
        mailService.sendEmail(mail);
    }
}