using System;
using System.Data;
using CMySql;
using MySql.Data.MySqlClient;

namespace MenuBueno
{

    class MainClass

    {
        private static IDbConnection dbConnection;
        public static void Main(string[] args)
        {
            Console.WriteLine("Acceso a dbprueba");
            dbConnection = new MySqlConnection(
                 "server=localhost;database=dbprueba;user=root;password=sistemas;ssl-mode=none"
            );
           

          
            menu();
          


        }


        public static void menu() {

            dbConnection.Open();
            int opcion = -1;

            while (opcion != 0)
            {

                Console.WriteLine("1-Añadir producto");
                Console.WriteLine("2-eliminar producto");
                Console.WriteLine("3-editar");
                Console.WriteLine("4-consultar");
                Console.WriteLine("5-Listra");
                Console.WriteLine("0-salir");
                Console.WriteLine("*************************");

                try
                {
                    opcion = int.Parse(System.Console.ReadLine());
                }
                catch
                {
                    Console.WriteLine("Formato invalido");
                }


                switch (opcion)
                {

                    case 1:
                        InsertValue();
                      
                        break;

                    case 2:
                        delete();
                        break;

                    case 3:
                        break;
                    case 4:
                        ShowMetaInfo();
                      
                        break;

                    case 5:

                        ShowAll();
                      

                        break;

                    case 0:
                        System.Environment.Exit(-1);
                        break;

                    default:
                        Console.WriteLine("Introduce una opcion correcta ");
                        break;

                }



            }



            dbConnection.Close();


        }

        public static void ShowAll()
        {

            IDbCommand dbCommand = dbConnection.CreateCommand();
            dbCommand.CommandText = "select * from categoria";
            IDataReader dataReader = dbCommand.ExecuteReader();

            while (dataReader.Read())
            {
                Console.WriteLine("id={0} nombre={1}", dataReader["id"], dataReader["nombre"]);
            }

            dataReader.Close();

        }


        public static void InsertValue()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            //string nombre = "nuevo " + DateTime.Now;
            Console.Write("Nombre: ");
            string nombre = Console.ReadLine();
            dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";

     
            DbCommandHelper.AddParameter(dbCommand, "nombre", nombre);

            dbCommand.ExecuteNonQuery();



        }


        public static void ShowMetaInfo()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            dbCommand.CommandText = "select * from categoria";
            IDataReader dataReader = dbCommand.ExecuteReader();

            Console.WriteLine("FieldCount={0}", dataReader.FieldCount);
            for (int index = 0; index < dataReader.FieldCount; index++)
                Console.WriteLine("Field {0,3} = {1,-15} Type= {2}", index, dataReader.GetName(index),
                  dataReader.GetFieldType(index));

            dataReader.Close();
        }

        public static void delete()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            Console.Write("id del elemento a eliminar");
            var numero = Console.ReadLine();

            dbCommand.CommandText = "delete from categoria where id=(@numero)";

            DbCommandHelper.AddParameter(dbCommand, "numero", numero);

            dbCommand.ExecuteNonQuery();




        }


    }


}
