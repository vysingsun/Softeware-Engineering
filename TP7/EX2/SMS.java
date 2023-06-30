public class SMS {
    String subject;
    String from_tel;
    String receiver_tel;
    String type;
    String content;
    String status;

    public SMS() {

    }

    public SMS(String subject, String from_tel, String receiver_tel, String type, String content, String status) {
        this.subject = subject;
        this.from_tel = checkTel(from_tel);
        this.receiver_tel = checkTel(receiver_tel);
        this.content = content;
        if (type.equalsIgnoreCase("Text") || type.equalsIgnoreCase("MMS")) {
            this.type = type;
        }
        if (status.equalsIgnoreCase("read") || status.equalsIgnoreCase("new")) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "Subject: " + subject + "\t" + "Phone number: " + from_tel + "\t" +
                "Recieve number: " + receiver_tel + "\t" + "Type of message: " + type + "\t" +
                "Content: " + content + "\t" + "Status: " + status + "\n";
    }

    public String getSubject() {
        return subject;
    }

    public String getFrom_tel() {
        return from_tel;
    }

    public String getReceiver_tel() {
        return receiver_tel;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    private String checkTel(String tel) {
        int check = 0;
        for (int i = 0; i < tel.length(); i++) {
            if (tel.charAt(i) >= '0' && tel.charAt(i) <= '9') {
                check = 1;
            } else {
                check = 0;
            }
        }
        if (check == 0) {
            return null;
        } else {
            return tel;
        }
    }
}