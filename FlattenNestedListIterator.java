/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> expanded = new ArrayList<>();
    int i = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        expand(nestedList);
    }

    private void expand(List<NestedInteger> nested) {
        for (int i = 0; i < nested.size(); i++) {
            if (nested.get(i).isInteger()) {
                expanded.add(nested.get(i).getInteger());
            } else {
                expand(nested.get(i).getList());
            }
        }
    }
    @Override
    public Integer next() {
        return expanded.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < expanded.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
