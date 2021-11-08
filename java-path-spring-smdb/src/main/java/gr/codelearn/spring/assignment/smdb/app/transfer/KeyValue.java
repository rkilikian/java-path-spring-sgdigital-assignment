package gr.codelearn.spring.assignment.smdb.app.transfer;

import lombok.Value;

@Value
public class KeyValue<K, V> {
    K key;
    V value;
}
