package com.gmail.max.client;

import com.google.gwt.i18n.client.LocalizableResource.Generate;

@Generate(format = "com.google.gwt.i18n.server.PropertyCatalogFactory")
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  @DefaultMessage("Enter your name")
  String nameField();

  @DefaultMessage("Send")
  String sendButton();

  @DefaultMessage("Title")
  String titleField();

  @DefaultMessage("Author")
  String authorField();

  @DefaultMessage("Date")
  String dateField();

  @DefaultMessage("Action")
  String actionField();

  @DefaultMessage("Remove")
  String removeField();

  @DefaultMessage("Show")
  String showBooks();

  @DefaultMessage("Add")
  String addBooks();





}
