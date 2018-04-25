package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.model.ScoreCard;
import com.example.model.StudentInfo;



@Repository
public class FrogRepositoryImpl implements FrogRepositoryDef {

 @PersistenceContext(unitName = "entityManagerFactory")
 public EntityManager em;
 private TransactionTemplate transactionTemplate;



 public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
  this.transactionTemplate = transactionTemplate;
 }

 public EntityManager getEm() {
  return em;
 }

 public void setEm(EntityManager em) {
  this.em = em;
 }

 @Override
 @Transactional(propagation = Propagation.REQUIRES_NEW)
 public StudentInfo addStudentInfo(StudentInfo p) {
  EntityManager em1 = getEm();
  em1.persist(p);
  return p;
 }
 @Override
 @Transactional
 public List < StudentInfo > getStudentInfoById(long Id) {
  EntityManager em1 = getEm();
  TypedQuery < StudentInfo > query = em.createQuery("SELECT c FROM StudentInfo c WHERE c.studentId = :id", StudentInfo.class);

  List < StudentInfo > s = query.setParameter("id", Id).getResultList();

  if (s.isEmpty()) {
   return null;
  } else {
   return s;

  }
 }
 @Override
 @Transactional
 public List < StudentInfo > getStudentInfoByClass(String className) {
  EntityManager em1 = getEm();
  TypedQuery < StudentInfo > query = em.createQuery("SELECT c FROM StudentInfo c WHERE c.classDetails = :name", StudentInfo.class);

  List < StudentInfo > s = query.setParameter("name", className).getResultList();

  if (s.isEmpty()) {
   return null;
  } else {
   return s;

  }
 }

 @Override
 @Transactional
 public List < StudentInfo > getStudentInfoByName(String student) {

  EntityManager em1 = getEm();
  TypedQuery < StudentInfo > query = em.createQuery("SELECT c FROM StudentInfo c WHERE c.firstName = :name", StudentInfo.class);

  List < StudentInfo > s = query.setParameter("name", student).getResultList();

  if (s.isEmpty()) {
   return null;
  } else {
   return s;

  }

 }
 @Override
 @Transactional
 public List < StudentInfo > getStudentInfoByLastName(String student) {

  EntityManager em1 = getEm();
  TypedQuery < StudentInfo > query = em.createQuery("SELECT c FROM StudentInfo c WHERE c.lastName = :name", StudentInfo.class);

  List < StudentInfo > s = query.setParameter("name", student).getResultList();

  if (s.isEmpty()) {
   return null;
  } else {
   return s;

  }

 }
 @Override
 @Transactional
 public List < StudentInfo > deleteById(String id) {
  EntityManager em1 = getEm();
  StudentInfo detail = em1.find(StudentInfo.class, Long.parseLong(id));
  String classDe = detail.getClassDetails();
  em1.remove(detail);
  TypedQuery < StudentInfo > query = em.createQuery("SELECT c FROM StudentInfo c WHERE c.classDetails = :name", StudentInfo.class);

  List < StudentInfo > s = query.setParameter("name", classDe).getResultList();

  if (s.isEmpty()) {
   return null;
  } else {
   return s;

  }
 }
 @Override
 @Transactional
 public List < StudentInfo > updateByDetails(StudentInfo id) {
  EntityManager em1 = getEm();
  ScoreCard score = em1.find(ScoreCard.class, id.getScoreCard().getScoreCardId());
  score.setSubject1(id.getScoreCard().getSubject1());
  score.setSubject2(id.getScoreCard().getSubject2());
  score.setSubject3(id.getScoreCard().getSubject3());
  StudentInfo detail = em1.find(StudentInfo.class, id.getStudentId());
  detail.setClassDetails(id.getClassDetails());
  detail.setFirstName(id.getFirstName());
  detail.setLastName(id.getLastName());
  detail.setScoreCard(score);
  em1.merge(detail);
  TypedQuery < StudentInfo > query = em.createQuery("SELECT c FROM StudentInfo c WHERE c.classDetails = :name", StudentInfo.class);

  List < StudentInfo > s = query.setParameter("name", id.getClassDetails()).getResultList();

  if (s.isEmpty()) {
   return null;
  } else {
   return s;

  }
 }


}
