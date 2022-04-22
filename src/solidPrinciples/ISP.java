package solidPrinciples;

/**
 * INTERFACE SEGREGATION PRINCIPLE
 */

class Document
{
}

interface Machine
{
  void print(Document d);
  void fax(Document d) throws Exception;
  void scan(Document d) throws Exception;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine
{
  public void print(Document d)
  {
    //
  }

  public void fax(Document d)
  {
    //
  }

  public void scan(Document d)
  {
    //
  }
}


class OldFashionedPrinter implements Machine
{
  public void print(Document d)
  {
    // yep, old fashion printer can do this
  }

  public void fax(Document d) throws Exception
  {
      //old fashion printer CAN NOT do this, but we have to implement something??? or throw exception
    throw new Exception();
  }

  public void scan(Document d) throws Exception
  {
      //old fashion printer CAN NOT do this, but we have to implement something??? or throw exception
    throw new Exception();
  }
}

interface Printer
{
  void Print(Document d) throws Exception;
}

interface IScanner
{
  void Scan(Document d) throws Exception;
}

class JustAPrinter implements Printer
{
  public void Print(Document d)
  {

  }
}

class Photocopier implements Printer, IScanner
{
  public void Print(Document d) throws Exception
  {
    throw new Exception();
  }

  public void Scan(Document d) throws Exception
  {
    throw new Exception();
  }
}

interface MultiFunctionDevice extends Printer, IScanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice
{
  // compose this out of several modules
  private Printer printer;
  private IScanner scanner;

  public MultiFunctionMachine(Printer printer, IScanner scanner)
  {
    this.printer = printer;
    this.scanner = scanner;
  }

  public void Print(Document d) throws Exception
  {
    printer.Print(d);
  }

  public void Scan(Document d) throws Exception
  {
    scanner.Scan(d);
  }
}