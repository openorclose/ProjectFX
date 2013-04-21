package common;

public interface Function<T> {
    public T isValid (String unchecked);
    public String getErrorMessage();
}
