package com.example.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;


@Entity
@Table
public class StudentInfo implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(columnDefinition = "serial", name = "STUDENT_ID")
 private long studentId;
 private String firstName;
 private String lastName;
 private String dateOfBirth;
 private String classDetails;
 @OneToOne(fetch = FetchType.EAGER, cascade = {
  CascadeType.ALL
 })
 @com.fasterxml.jackson.annotation.JsonFormat(with = Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
 private ScoreCard scoreCard;
 //@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
 //@JoinColumn(name="Scorecard_ID")
 /// private ScoreCard score;

 //public ScoreCard getScore() {
 //	return score;
 //}
 //public void setScore(ScoreCard score) {
 //	this.score = score;
 //}

 public long getStudentId() {
  return studentId;
 }
 public ScoreCard getScoreCard() {
  return scoreCard;
 }
 public void setScoreCard(ScoreCard scoreCard) {
  this.scoreCard = scoreCard;
 }
 public void setStudentId(long studentId) {
  this.studentId = studentId;
 }
 public String getFirstName() {
  return firstName;
 }
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }
 public String getLastName() {
  return lastName;
 }
 public void setLastName(String lastName) {
  this.lastName = lastName;
 }
 public String getDateOfBirth() {
  return dateOfBirth;
 }
 public void setDateOfBirth(String dateOfBirth) {
  this.dateOfBirth = dateOfBirth;
 }
 public String getClassDetails() {
  return classDetails;
 }
 public void setClassDetails(String classDetails) {
  this.classDetails = classDetails;
 }
}
