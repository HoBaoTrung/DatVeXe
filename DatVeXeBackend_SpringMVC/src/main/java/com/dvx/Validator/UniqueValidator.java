///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.dvx.Validator;
//import com.dvx.MyAnnotation.Unique;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class UniqueValidator implements ConstraintValidator<Unique, String> {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private String fieldName;
//    private Class<?> domainClass;
//
//    @Override
//    public void initialize(Unique unique) {
//        this.fieldName = unique.fieldName();
//        this.domainClass = unique.domainClass();
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (value == null || value.isEmpty()) {
//            return true; // Trường hợp cho phép null hoặc rỗng
//        }
//
//        String query = String.format("SELECT COUNT(e) FROM %s e WHERE e.%s = :value", domainClass.getSimpleName(), fieldName);
//        Long count = (Long) entityManager.createQuery(query)
//                                         .setParameter("value", value)
//                                         .getSingleResult();
//        return count == 0;
//    }
//}
