package com.gmail.max.client;

import com.gmail.max.client.service.LibraryController;
import com.gmail.max.client.service.LibraryControllerAsync;
import com.gmail.max.client.view.DialogBoxView;
import com.gmail.max.client.view.MainTableViewImpl;
import com.gmail.max.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LibraryMy implements EntryPoint {



  //private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    RootPanel.get("mainTable").add(new MainTableViewImpl());
  }
}
