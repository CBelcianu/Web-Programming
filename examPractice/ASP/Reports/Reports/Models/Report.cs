using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Reports.Models
{
    public class Report
    {
        public int id { get; set; }
        public string type { get; set; }
        public string severity { get; set; }
        public string author { get; set; }
    }
}