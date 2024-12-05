package kiosk.model;

import kiosk.model.enums.Status;

public class Kiosk {
    private Status status; // active, inactive

    public Kiosk(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void start() {
        setStatus(Status.ACTIVE);
        System.out.println("키오스크 시작");
    }

    public void shutdown() {
        setStatus(Status.INACTIVE);
        System.out.println("키오스크 종료");
    }
}
