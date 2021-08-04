package hk.cloudcall.bcrypt.controller;

import hk.cloudcall.bcrypt.param.BaseResult;
import hk.cloudcall.bcrypt.param.BcryptParams;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {
    static Random random = new Random();

    public String encode(String rawPassword) {
        int strength = 10;
        String salt = BCrypt.gensalt(strength);
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    @PostMapping("/match")
    public BaseResult match(@RequestBody @Validated BcryptParams bp) {
        BaseResult result = new BaseResult();
        result.setSuccess(BCrypt.checkpw(bp.getPlaniText(), bp.getHashed()));

        return result;
    }

    @PostMapping("/encode")
    public String encode(@RequestBody @Validated BcryptParams bp) {
        return encode(bp.getPlaniText());
    }


}

