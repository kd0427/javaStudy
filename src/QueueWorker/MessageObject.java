package QueueWorker;

public class MessageObject {
    private int msg;

    public MessageObject(int payload) {
        this.msg = payload;
    }


    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }
}


