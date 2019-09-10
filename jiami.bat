#server:
#  port: 9999
#spring:
#  jackson:
#    date-format: yyyy-mm-dd HH:mm:ss
#    time-zone: GMT+8

spring:
  profiles:
    active: test


#  java -jar zimugeyjb-1.0.0.jar --spring.profiles.active=test

jasypt:
  encryptor:
    password: 123456