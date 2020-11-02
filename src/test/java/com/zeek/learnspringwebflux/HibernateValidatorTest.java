package com.zeek.learnspringwebflux;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-10-15
 */
public class HibernateValidatorTest {

    private static Validator validator;

    private static ExecutableValidator executableValidator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        executableValidator = factory.getValidator().forExecutables();

    }

    @Test
    void testMethodAndParameterValidator() {

    }

    @Test
    void testFieldAndClassValidator() {

        User user = new User(null, "123", "!@#$", null, 11);

        // 验证所有bean的所有约束
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        // 验证单个属性
        Set<ConstraintViolation<User>> constraintViolations2 = validator.validateProperty(user, "name");
        // 检查给定类的单个属性是否可以成功验证
        Set<ConstraintViolation<User>> constraintViolations3 = validator.validateValue(User.class, "password", "sa!");

        constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
        System.out.println("======");
        constraintViolations2.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
        System.out.println("======");
        constraintViolations3.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
    }
}
