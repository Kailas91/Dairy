SELECT 
    p.ProductName,
    SUM(ordt.UnitPrice * ordt.Quantity) AS TotalPurchase
FROM
    products p
        JOIN
    suppliers sup ON sup.SupplierID = p.SupplierID
        JOIN
    orderDetails AS ordt ON ordt.productid = p.productid
        JOIN
    orders o ON o.OrderID = ordt.OrderID
        JOIN
    categories cat ON cat.CategoryID = p.CategoryID
        where YEAR(o.orderDate) IN ("1996")
        AND cat.categoryName = "Produce"
GROUP BY p.productName
ORDER BY p.productName;