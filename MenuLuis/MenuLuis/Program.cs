using System;
using System.Collections.Generic;

namespace MenuLuis
{
    class Menu
    {
        private bool exit = false;
        private string menuLabel;
        private IList<String> labels = new List<String>();
        private IDictionary<string, Action> actions =
           new Dictionary<string, Action>();

        public static Menu Create(String menuLabel) {
            return new Menu(menuLabel);
        
        }

        private Menu(string menuLabel)
        {
            this.menuLabel = menuLabel;
        }



    }
}
