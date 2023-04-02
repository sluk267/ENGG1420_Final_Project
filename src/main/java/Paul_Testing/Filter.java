/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
public abstract class Filter extends ProcessingElement {
    public abstract boolean filter_entry(Entry entry);
}

public class NameFilter extends Filter {
    private String pattern;
    
    public NameFilter(String pattern) {
        this.pattern = pattern;
    }
    
    public boolean filter_entry(Entry entry) {
        return entry.get_name().matches(pattern);
    }
}

public class LengthFilter extends Filter {
    private int min_length;
    private int max_length;
    
    public LengthFilter(int min_length, int max_length) {
        this.min_length = min_length;
        this.max_length = max_length;
    }
    
    public boolean filter_entry(Entry entry) {
        if (entry.get_type() == EntryType.FILE) {
            int length = ((FileEntry) entry).get_length();
            return length >= min_length && length <= max_length;
        } else {
            return true;
        }
    }
}

public class ContentFilter extends Filter {
    private String pattern;
    
    public ContentFilter(String pattern) {
        this.pattern = pattern;
    }
    
    public boolean filter_entry(Entry entry) {
        if (entry.get_type() == EntryType.FILE) {
            String content = ((FileEntry) entry).get_content();
            return content.contains(pattern);
        } else {
            return true;
        }
    }
}

public class CountFilter extends Filter {
    private int max_count;
    private int count;
    
    public CountFilter(int max_count) {
        this.max_count = max_count;
        this.count = 0;
    }
    
    public boolean filter_entry(Entry entry) {
        if (count < max_count) {
            count++;
            return true;
        } else {
            return false;
        }
    }
}
