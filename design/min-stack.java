class MinStack {
    private List<int[]> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        int curMin;
        if (list.isEmpty()) {
            curMin = val;
        } else {
            curMin = Math.min(val, list.get(list.size() - 1)[1]);
        }
        list.add(new int[]{val, curMin});
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1)[0];
    }

    public int getMin() {
        return list.get(list.size() - 1)[1];
    }
}
