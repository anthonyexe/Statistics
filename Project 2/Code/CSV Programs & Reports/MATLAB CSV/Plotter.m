function Plotter(fileName, min, max, increment)
    p = [1 2 1];
    x = min:increment:max;
    y = polyval(p,x);

    PlottingFigure = figure('Name', 'Plotter');
    plot(x, y)
    title("Population Size of " + max + " With an Increment of " + increment)

    xy = [x;y];
    xy = xy';
    disp(xy)

    writematrix(xy, fileName)
end
