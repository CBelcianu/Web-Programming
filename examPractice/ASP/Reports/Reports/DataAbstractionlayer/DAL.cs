using MySql.Data.MySqlClient;
using Reports.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Reports.DataAbstractionlayer
{
    public class DAL
    {
        private User currentUser;

        public User GetUser()
        {
            return currentUser;
        }

        public string ValidateData(string user, string pass)
        {
            string result = "";

            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp2;";

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

        internal List<Report> GetAllReports(int start, int end)
        {
            List<Report> recipies = new List<Report>();

            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp2;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from report ORDER BY id LIMIT 4 OFFSET " + start;
                MySqlDataReader myreader = cmd.ExecuteReader();

                while (myreader.Read())
                {
                    Report stud = new Report();
                    stud.id = (int)myreader["id"];
                    stud.type = (string)myreader["type"];
                    stud.severity = (string)myreader["severity"];
                    stud.author = (string)myreader["username"];
                    recipies.Add(stud);
                }
                myreader.Close();

                cmd.CommandText = "select * from report ORDER BY id LIMIT 4 OFFSET " + end;
                MySqlDataReader newreader = cmd.ExecuteReader();

                while (newreader.Read())
                {
                    Report stud = new Report();
                    stud.id = (int)newreader["id"];
                    stud.type = (string)newreader["type"];
                    stud.severity = (string)newreader["severity"];
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

        internal void delReport(string name, string username)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp2;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "delete from report where type='" + name + "' and username='" + username + "'";
                cmd.ExecuteNonQuery();
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write(ex.Message);
            }
        }

        internal void addReport(string name, string category, string username)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp2;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "insert into report(type,severity,username) values('" + name + "','" + category + "','" + username + "')";
                cmd.ExecuteNonQuery();
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write(ex.Message);
            }
        }

        internal List<Report> GetMyReports(int start, int end, string username)
        {
            List<Report> recipies = new List<Report>();

            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;

            myConnectionString = "server=localhost;uid=root;pwd=;database=asp2;";

            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from report where username='" + username + "' ORDER BY id LIMIT 4 OFFSET " + start;
                MySqlDataReader myreader = cmd.ExecuteReader();

                while (myreader.Read())
                {
                    Report stud = new Report();
                    stud.id = (int)myreader["id"];
                    stud.type = (string)myreader["type"];
                    stud.severity = (string)myreader["severity"];
                    stud.author = (string)myreader["username"];
                    recipies.Add(stud);
                }
                myreader.Close();

                cmd.CommandText = "select * from report where username='" + username + "' ORDER BY id LIMIT 4 OFFSET " + end;
                MySqlDataReader newreader = cmd.ExecuteReader();

                while (newreader.Read())
                {
                    Report stud = new Report();
                    stud.id = (int)newreader["id"];
                    stud.type = (string)newreader["type"];
                    stud.severity = (string)newreader["severity"];
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