angular.module('portfolioApp', []) 
 .controller('PortfolioController', function($scope) { 
 $scope.portfolio = {}; 
 $scope.generatePDF = function() { 
 var doc = new jsPDF(); 
 doc.setFontSize(18); 
 doc.text("Portfolio", 10, 10); 
 doc.setFontSize(12); 
 var splitBio = doc.splitTextToSize($scope.portfolio.bio, 180); 
 var splitSkills = doc.splitTextToSize($scope.portfolio.skills, 180); 
 doc.text("Name: " + $scope.portfolio.name, 10, 30); 
 doc.text("Email: " + $scope.portfolio.email, 10, 40); 
 doc.text("Bio:", 10, 50); 
 doc.text(splitBio, 10, 60, { maxWidth: 180, lineHeight: 1.5 }); 
 doc.text("Skills:", 10, 100); 
 doc.text(splitSkills, 10, 110, { maxWidth: 180, lineHeight: 1.5 }); 
 doc.save("portfolio.pdf"); 
 }; 
 }); 