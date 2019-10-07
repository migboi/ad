using System;
namespace CGtk
{
    public partial class Cayegoria : Gtk.Window
    {
        public Cayegoria() :
                base(Gtk.WindowType.Toplevel)
        {
            this.Build();
            button5.Clicked += (sender, e) => this.Destroy();
        }
    }
}
