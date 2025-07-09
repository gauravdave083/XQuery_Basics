
# 📘 XQuery: Basic Concepts & Assignments

This repository contains basic XQuery scripts, notes, and sample assignments for understanding how to query and transform XML data using **XQuery**.

---

## 📌 Table of Contents

- [Introduction](#introduction)
- [What is XQuery?](#what-is-xquery)
- [Basic Concepts](#basic-concepts)
- [Files Included](#files-included)
- [How to Run](#how-to-run)
- [References](#references)

---

## 📖 Introduction

**XQuery** (XML Query Language) is a powerful language used to query, transform, and generate XML data.  
It is designed to work with XML and related technologies like XPath and XSLT.

---

## ❓ What is XQuery?

- A W3C standard query language for XML data.
- Similar to SQL for relational databases.
- Can filter, sort, join, and transform XML documents.
- Useful for data integration, web services, and content management.

---

## 🧩 Basic Concepts Covered

✅ **FLWOR Expressions** (For-Let-Where-Order-Return)  
✅ **XPath Basics**  
✅ **Conditional Expressions** (`if-then-else`)  
✅ **Functions and Modules**  
✅ **Constructing XML Output**  
✅ **Working with Multiple XML Documents**

---

## 📂 Files Included

```
xquery-basics/
├── data/                 # Sample XML files
│   ├── books.xml
│   └── students.xml
├── queries/              # XQuery scripts for assignments
│   ├── books-query.xq
│   ├── students-filter.xq
│   └── flwor-example.xq
├── README.md             # This file
```

---

## ▶️ How to Run

1. **Install an XQuery processor** — e.g., [BaseX](https://basex.org/).

2. **Run a query:**
   ```bash
   basex queries/books-query.xq
   ```

3. **Modify XML files in `data/` to test different scenarios.**

---

## 📚 References

- [W3C XQuery Specification](https://www.w3.org/TR/xquery/)
- [BaseX Documentation](https://docs.basex.org/)
- [Saxon XQuery Processor](https://www.saxonica.com/)

---

**This repository is for learning purposes only. Feel free to fork and use for your assignments!**

📌 *Happy Learning!*
