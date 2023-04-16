%Call the plotter function
Plotter('xyValues.csv', 1, 500, 0.5)

%Call the salter function
Salter('xyValues.csv', 0, 100000)

%Call the smoother function
Smoother('saltedxyValues.csv', 25)