package tn.esprit.spring.services;

public interface mailservice {
    public void sendMessageWithAttachment(
            String to,  String username, String trainingname,String trainer);
}
