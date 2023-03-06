//package com.example.supermarketstore.domain.specification;
//
//import com.example.supermarketstore.domain.Store;
//import jakarta.persistence.criteria.Predicate;
//import org.springframework.data.jpa.domain.Specification;
//import java.util.ArrayList;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//public class StoreSpecification {
//    public StoreSpecification() {
//        super();
//    }
//
//    public static Specification<Store> createSpecification(Date dateReceived) {
//        return (root, query, cb) -> {
//            final ArrayList<Predicate> predicates = new ArrayList<>();
//
//            if (dateReceived!=null && !includeClosed) {
//                predicates.add(cb.equal(root.get("active"), true));
//            }
//
//            if (type != null) {
//                predicates.add(cb.equal(root.get("supplierType"), type));
//            }
//            if (term != null) {
//                String likeExpression = "%" + term.toLowerCase() + "%";
//                predicates.add(cb.like(root.get("supplierName"), likeExpression));
//            }
//            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//        };
//    }
//}
//
//
//
