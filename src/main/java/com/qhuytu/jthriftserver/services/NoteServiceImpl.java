package com.qhuytu.jthriftserver.services;

import com.qhuytu.jthriftfiles.exceptions.CanNotFoundException;
import com.qhuytu.jthriftfiles.exceptions.InvalidTypeException;
import com.qhuytu.jthriftfiles.services.NoteService;
import com.qhuytu.jthriftfiles.structs.Note;

import java.util.HashMap;

public class NoteServiceImpl implements NoteService.Iface {

    private static HashMap<Integer, Note> notes = new HashMap<Integer, Note>();
    private static int lastId = 1;

    public void addNote(Note note) throws InvalidTypeException {
        if (note.content.length() == 0) {
            throw new InvalidTypeException("Note content can not be empty");
        }

        note.id = lastId++;
        notes.put(note.id, note);
    }

    public HashMap getNotes() {
        return notes;
    }

    public Note getNote(int id) throws CanNotFoundException {
        if (!notes.containsKey(id)) {
            throw new CanNotFoundException("Can not found id " + id);
        }

        return notes.get(id);
    }

    public void updateNote(Note note) throws InvalidTypeException, CanNotFoundException {
        if (note.content.length() == 0) {
            throw new InvalidTypeException("Note content can not be empty");
        }
        if (!notes.containsKey(note.id)) {
            throw new CanNotFoundException("Can not found id " + note.id);
        }

        notes.put(note.id, note);
    }

    public void deleteNote(int id) throws CanNotFoundException {
        if (!notes.containsKey(id)) {
            throw new CanNotFoundException("Can not found id " + id);
        }

        notes.remove(id);
    }

    public void triggerNote(int id) throws CanNotFoundException {
        Note note = getNote(id);
        note.isFinish = !note.isFinish;
        notes.put(id, note);
    }
}
