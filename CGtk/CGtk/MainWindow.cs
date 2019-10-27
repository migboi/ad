﻿using System;
using Gtk;
using CGtk;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();
        treeview.AppendColumn("id", new CellRendererText(),"text",0);
        treeview.AppendColumn("id", new CellRendererText(), "text", 1);

         ListStore listStore = new ListStore(typeof(String), typeof(String));

        treeview.Model = listStore;

        listStore.AppendValues("1", "cat 1");

        listStore.AppendValues("2", "cat 3");


        newAction.Activated += (sender, e) => new Cayegoria();


    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}