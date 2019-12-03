USE ConsumerComplaints;

SELECT DateReceived, Product, Company, State
FROM Complaint;

-- Two dashes is a SQL comment. This line is ignored.
-- If your query has many columns, you may want to stack them for readability. 
-- Whitespace is ignored.
SELECT 
    DateReceived, 
    Product, 
    Issue, 
    Company
FROM Complaint
WHERE State = 'LA';

SELECT *
FROM Complaint
WHERE State = 'LA'
AND (Product = 'Mortgage' OR Product = 'Debt collection');

SELECT *
FROM Complaint
WHERE State = 'LA'
AND Product = 'Mortgage' OR Product = 'Debt collection';

SELECT 
    Product, 
    Issue, 
    Company, 
    ResponseToConsumer
FROM Complaint
WHERE ConsumerDisputed = 1
AND ConsumerConsent = 1
AND Product NOT IN ('Mortgage', 'Debt collection');