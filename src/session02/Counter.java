package session02;

class Counter {
    private int count = 0;

    void incr() {
        if (count > 9999) {
            count = 9999;
        } else {
            ++count;
        }
    }

    void dec() {
        if (count < 0) {
            reset();
        } else {
            --count;
        }
    }

    void read() {
        System.out.println(count);
    }

    private void reset() {
        count = 0;
    }
}
