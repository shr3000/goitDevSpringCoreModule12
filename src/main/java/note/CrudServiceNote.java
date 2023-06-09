package note;

import java.util.HashMap;
import java.util.Map;

public class CrudServiceNote {
    private Map<Long, Note> notes = new HashMap<>();
    public void add(Note note) {
        Long id = note.getId();
        if (notes.containsKey(id)) {
            throw new IllegalArgumentException("Note already exists");
        } else {
            notes.put(getMaxId() + 1, note);
        }
    }
    public void delete(Long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note not found");
        } else {
            notes.remove(id);
        }
    }
    public void update(Note note) {
        Long id = note.getId();
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note not found");
        } else {
            notes.put(id, note);
        }
    }
    public Map<Long, Note> getAll() {
        return notes;
    }
    public Note getById(Long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note not found");
        }
        return notes.get(id);
    }

    private Long getMaxId() {
        return notes.keySet().stream().max(Long::compareTo).get();
    }
}

