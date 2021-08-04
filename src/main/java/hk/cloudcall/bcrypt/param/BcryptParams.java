package hk.cloudcall.bcrypt.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * BcryptParams class
 *
 * @author MIKE
 * @date 20210803
 */
@Setter
@Getter
@ToString
public class BcryptParams {

    // 加密后的串
    private String hashed;

    // 原始串
    private String planiText;

}
