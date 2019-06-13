using ASPX1.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ASPX1.DataAbstractionLayer
{
    public class DAL
    {
        private User currentUser;

        public User GetUser()
        {
            return currentUser;
        }

        public void addRecipe(string name, string category, string username)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp1;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "insert into recipies(name,category,username) values('" + name + "','" + category + "','" + username +"')";
                cmd.ExecuteNonQuery();
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write(ex.Message);
            }
        }

        public void delRecipe(string name, string username)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp1;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "delete from recipies where name='" + name + "' and username='" + username + "'";
                cmd.ExecuteNonQuery();
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write(ex.Message);
            }
        }

        public string ValidateData(string user, string pass)
        {
            string result = "";

            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp1;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from users where username='" + user + "' and password='" + pass + "'";
                MySqlDataReader myreader = cmd.ExecuteReader();

                if (myreader.HasRows)
                {

                    result = "success";
                    currentUser = new User();
                    currentUser.username = user;
                    currentUser.password = pass;
                }
                else
                {
                    result = "error";
                }
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write(ex.Message);
            }

            return result;
        }

        public List<Recipie> GetRecipies(int start, int end)
        {
            List<Recipie> recipies = new List<Recipie>();

            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp1;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from recipies ORDER BY id LIMIT 4 OFFSET " + start;
                MySqlDataReader myreader = cmd.ExecuteReader();

                while (myreader.Read())
                {
                    Recipie stud = new Recipie();
                    stud.id = (int)myreader["id"];
                    stud.name = (string)myreader["name"];
                    stud.category = (string)myreader["category"];
                    stud.author = (string)myreader["username"];
                    recipies.Add(stud);
                }
                myreader.Close();
                
                cmd.CommandText = "select * from recipies ORDER BY id LIMIT 4 OFFSET " + end;
                MySqlDataReader newreader = cmd.ExecuteReader();

                while (newreader.Read())
                {
                    Recipie stud = new Recipie();
                    stud.id = (int)newreader["id"];
                    stud.name = (string)newreader["name"];
                    stud.category = (string)newreader["category"];
                    stud.author = (string)newreader["username"];
                    recipies.Add(stud);
                }
                newreader.Close();


            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write(ex.Message);
            }


            return recipies;
        }
    }
}