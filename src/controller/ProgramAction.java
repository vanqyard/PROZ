package controller;

import events.ProgramEvent;

/**
 * Created by vanqyard on 2/3/15.
 */
public interface ProgramAction {
    abstract public void go(ProgramEvent e);
}